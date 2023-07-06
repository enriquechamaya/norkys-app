let carrito = [];

$(document).ready(function () {
    listarCarrito();
});

function listarCarrito() {
    let total = 0;
    if (localStorage.getItem("miCarrito") !== null
            && typeof localStorage.getItem("miCarrito") !== 'undefined') {
        carrito = JSON.parse(localStorage.getItem("miCarrito"));
    }

    $("#tbl_productos_carrito").empty();
    $.each(carrito, function () {
        $("#tbl_productos_carrito").append(`
                        <tr>
                            <th scope="row">${this.id}</th>
                            <td>${this.nombre}</td>
                            <td>${this.cantidad}</td>
                            <td>${this.precio}</td>
                            <td>${this.cantidad * this.precio}</td>
                            <td>
                                <button type="button" class="btn btn-danger" onclick="eliminarProductoCarrito(${this.id})">Eliminar</button>
                            </td>
                        </tr>
        `);
        total += this.cantidad * this.precio;
    });
    $("#tbl_productos_carrito").append(`
        <tr>
            <td colspan="4" class="text-right font-weight-bold">
                <h2 class="h2">TOTAL S/.</h2>
            </td>
            <td colspan="2" class="text-left">
                <h2 class="h2">${total}</h2>
            </td>
        </tr>
    `);
}

function eliminarProductoCarrito(id) {
    let idx = carrito.findIndex(p => p.id === id);
    if (idx !== -1) {
        //quita el producto de la lista
        carrito.splice(idx, 1);

        // reasignar el nuevo valor en el localstorage
        localStorage.clear();
        localStorage.setItem("miCarrito", JSON.stringify(carrito));
        setCarrito();
        listarCarrito();
    }
}

function setCarrito() {
    if (localStorage.getItem("miCarrito") !== null
            && typeof localStorage.getItem("miCarrito") !== 'undefined') {
        carrito = JSON.parse(localStorage.getItem("miCarrito"));
    }
}