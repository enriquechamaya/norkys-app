let carrito = [];

$(document).ready(function () {
    listarProductos(1);
    setCarrito();
    mostrarCarrito();
});

function click_dinamico(nro) {
    desactivar_activo();
    switch (nro) {
        case 1:
            $("#btn_pollos").addClass("active");
            listarProductos(1);
            break;
        case 2:
            $("#btn_bebidas").addClass("active");
            listarProductos(2);
            break;
        case 3:
            $("#btn_ensaladas").addClass("active");
            listarProductos(3);
            break;
        case 4:
            $("#btn_postres").addClass("active");
            listarProductos(4);
            break;
        default:
            break;
    }
}

function desactivar_activo() {
    $("#btn_pollos").removeClass("active");
    $("#btn_bebidas").removeClass("active");
    $("#btn_ensaladas").removeClass("active");
    $("#btn_postres").removeClass("active");
}

function listarProductos(categoriaId) {
    $("#container_productos").empty();
    $.ajax({
        type: 'GET',
        url: "../../ProductoController?accion=listarPorCategoria",
        data: {
            categoriaId: categoriaId
        },
        success: function (data, textStatus, jqXHR) {
            console.log(data);

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
                        <img class="card-img-top" src="../../img-productos/cocacola.jpg">
                        <div class="card-body">
                            <h5 class="card-title text-secondary">${data[i].nombre}</h5>
                            <h4 class="card-title">S/. ${data[i].precioUnitario}</h4>
                        </div>
                        <div class="card-footer text-center">
                            <button class="btn btn-primary" onclick="agregarCarrito('${data[i].id}','${data[i].nombre}','${data[i].precioUnitario}')">
                                Agregar al carrito
                            </button>
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
        }
    });
}

function agregarCarrito(id, nombre, precio) {
    // arma obj producto
    let producto = {
        id: id,
        nombre: nombre,
        precio: precio,
        cantidad: 1
    };

    // valida si el producto existe entonce aumentar cantidad
    if (localStorage.getItem("miCarrito") !== null
            && typeof localStorage.getItem("miCarrito") !== 'undefined') {

        const productoExiste = carrito.find(p => p.id === producto.id);
        console.log("producto existe: ", productoExiste);
        if (productoExiste !== null && typeof productoExiste !== 'undefined') {
            productoExiste.cantidad += 1;
        } else {
            carrito.push(producto);
            toastr.success('Producto agregado al carrito', 'Mensaje exitoso');
        }
    } else {
        carrito.push(producto);
        toastr.success('Producto agregado al carrito', 'Mensaje exitoso');
    }

    // agregar carrito al localStorage
    localStorage.clear();
    localStorage.setItem("miCarrito", JSON.stringify(carrito));

    mostrarCarrito();
}

function mostrarCarrito() {
    // mostrar contador de items
    if (carrito.length > 0) {
        $("#btn_carrito").removeAttr('style');
        $("#btn_carrito").css('dispay', 'block');
        $("#btn_carrito").empty();
        $("#btn_carrito").append(`
            Carrito <span class="badge badge-light">${carrito.length}</span>
        `);
    } else {
        $("#btn_carrito").css('dispay', 'none');
    }
}

function setCarrito() {
    if (localStorage.getItem("miCarrito") !== null
            && typeof localStorage.getItem("miCarrito") !== 'undefined') {
        carrito = JSON.parse(localStorage.getItem("miCarrito"));
    }
}