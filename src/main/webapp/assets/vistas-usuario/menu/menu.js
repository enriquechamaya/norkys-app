let carrito = new Array();
let categorias = new Array();

$(document).ready(function () {
    listarCategorias();
    inicializarCarrito();
});

function desactivar_botones_dinamicos() {
    $("#btn_pollos").removeClass("active");
    $("#btn_bebidas").removeClass("active");
    $("#btn_ensaladas").removeClass("active");
    $("#btn_postres").removeClass("active");
}

function botones_dinamicos(id) {
    $.each(categorias, function () {
        $("#btn_cat_" + this.id).removeClass("active");
        if (this.id === id) {
            $("#btn_cat_" + id).addClass("active");
            listarProductos(id);
        }
    });
}

function listarProductos(categoriaId) {
    $("#container_productos").empty();
    $.ajax({
        type: 'GET',
        url: "../../ProductoController?accion=listarPorCategoria",
        data: {
            categoriaId: categoriaId
        },
        beforeSend: function (xhr) {
            $.LoadingOverlay("show");
        },
        success: function (data, textStatus, jqXHR) {
            if (data.length > 0) {
                var container = document.getElementById('container_productos');
                var row;
                var br;

                for (var i = 0; i < data.length; i++) {
                    if (i % 3 === 0) {
                        row = document.createElement('div');
                        row.className = 'row card-deck';
                        container.appendChild(row);

                        br = document.createElement('br');
                        container.appendChild(br);
                    }

                    var column = document.createElement('div');
                    column.className = 'col-md-4';

                    column.innerHTML = `
                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="../../img-productos/${data[i].imagen}">
                        <div class="card-body">
                            <h5 class="card-title text-secondary">${data[i].nombre}</h5>
                            <h4 class="card-title">S/. ${data[i].precioUnitario}</h4>
                            <div class="row">
                                <div class="col-md-4">
                                    <span class="badge badge-light" id="cant_${data[i].id}">
                                        Cantidad: <b>0</b>
                                    </span>
                                </div>
                                <div class="col-md-8 text-right">
                                    <button class="btn btn-info" id="btn_agregar_${data[i].id}" onclick="agregar(${data[i].id},'${data[i].nombre}',${data[i].precioUnitario})">+</button>
                                    <button class="btn btn-danger disabled" id="btn_quitar_${data[i].id}" onclick="quitar(${data[i].id})">-</button>
                                </div>
                            </div>
                        </div>
                    </div>`;
                    row.appendChild(column);
                }
            } else {
                $("#container_productos").append(`
                    <div class="alert alert-warning" role="alert" style="width: 100%">
                      No se encontraron productos para la categoría seleccionada
                    </div>                
                `);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición listarProductos', 'Error interno');
        },
        complete: function (jqXHR, textStatus) {
            mostrarInfoCantidad();
            mostrarInfoBotonQuitar();
            $.LoadingOverlay("hide");
        }
    });
}

function agregar(id, nombre, precio) {
    let producto = {id, nombre, precio, cantidad: 1};
    agregarCarrito(producto);
    mostrarBotonQuitar(producto.id, producto.cantidad);
}

function quitar(id) {
    if (carrito.length > 0) {
        let productoEncontrado = carrito.find(p => p.id === id);
        if (productoEncontrado) {
            if (productoEncontrado.cantidad > 0) {
                productoEncontrado.cantidad -= 1;
                mostrarBotonQuitar(id, productoEncontrado.cantidad);
                mostrarCantidad(id, productoEncontrado.cantidad);
                actualizarLocalStorage(productoEncontrado);
                eliminarProductoDelStorage(productoEncontrado);
                mostrarInfoCarrito();
            }
        }
    }
}

function agregarCarrito(producto) {
    if (carrito.length > 0) {
        let productoEncontrado = carrito.find(p => p.id === producto.id);
        if (productoEncontrado) {
            productoEncontrado.cantidad += 1;
            mostrarCantidad(productoEncontrado.id, productoEncontrado.cantidad);
        } else {
            carrito.push(producto);
            mostrarCantidad(producto.id, producto.cantidad);
        }
    } else {
        carrito.push(producto);
        mostrarCantidad(producto.id, producto.cantidad);
    }
    actualizarLocalStorage(carrito);
    mostrarInfoCarrito();
}

function mostrarBotonQuitar(id, cantidad) {
    if (cantidad > 0) {
        $("#btn_quitar_" + id).removeClass("disabled");
    } else {
        $("#btn_quitar_" + id).addClass("disabled");
    }
}
function mostrarCantidad(id, cantidad) {
    if (cantidad >= 0) {
        $("#cant_" + id).empty();
        $("#cant_" + id).append("Cantidad: " + cantidad);
    }
}

function actualizarLocalStorage(carrito) {
    localStorage.setItem("carritoBD", JSON.stringify(carrito));
}

function eliminarProductoDelStorage(producto) {
    if (producto.cantidad === 0) {
        let idx = carrito.findIndex(p => p.id === producto.id);
        carrito.splice(idx, 1);
        actualizarLocalStorage(carrito);
    }
}

function inicializarCarrito() {
    let carritoBD = localStorage.getItem("carritoBD");
    if (carritoBD !== null && typeof carritoBD !== "undefined") {
        let data = JSON.parse(carritoBD);
        if (data.length > 1) {
            carrito = data;
        } else {
            carrito.push(data[0]);
        }
    }
    mostrarInfoCarrito();
}

function mostrarInfoCarrito() {
    if (carrito.length > 0) {
        $("#btn_carrito").css("visibility", "visible");
        $("#btn_carrito").empty();
        $("#btn_carrito").append(`
            Carrito <span class="badge badge-light">${carrito.length}</span>
        `);
    } else {
        $("#btn_carrito").css("visibility", "hidden");
    }
}

function mostrarInfoCantidad() {
    if (carrito.length > 0) {
        $.each(carrito, function () {
            mostrarCantidad(this.id, this.cantidad);
        });
    }
}

function mostrarInfoBotonQuitar() {
    if (carrito.length > 0) {
        $.each(carrito, function () {
            mostrarBotonQuitar(this.id, this.cantidad);
        });
    }
}

function listarCategorias() {
    $.ajax({
        type: 'GET',
        url: "../../CategoriaController",
        beforeSend: function (xhr) {
            $.LoadingOverlay("show");
        },
        success: function (data, textStatus, jqXHR) {
            if (data.length > 0) {
                categorias = data;
                $.each(data, function () {
                    $("#btn_categorias").append(`
                        <button type="button" id="btn_cat_${this.id}" class="btn btn-outline-success" onclick="botones_dinamicos(${this.id})">${this.nombre}</button>
                    `);
                });
                $("#btn_cat_" + data[0].id).addClass("active");
                listarProductos(data[0].id);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición listarProductos', 'Error interno');
        },
        complete: function (jqXHR, textStatus) {
            $.LoadingOverlay("hide");
        }
    });
}