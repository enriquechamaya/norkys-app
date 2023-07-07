let carrito = new Array();

$(document).ready(function () {
    inicializarCarrito();
    listarCarrito();
});


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
    console.log(carrito);
}

function listarCarrito() {
    let total = 0;

    $("#tbl_productos_carrito").empty();
    $.each(carrito, function () {
        $("#tbl_productos_carrito").append(`
            <tr>
                <th scope="row">${this.id}</th>
                <td>${this.nombre}</td>
                <td>${this.cantidad}</td>
                <td>${this.precio}</td>
                <td><b>${this.cantidad * this.precio}</b></td>
            </tr>
        `);
        total += this.cantidad * this.precio;
    });
    $("#tbl_productos_carrito").append(`
        <tr>
            <td colspan="4" class="text-right font-weight-bold">
                <h2 class="h2">TOTAL S/.</h2>
            </td>
            <td colspan="1" class="text-left">
                <h2 class="h2">${total}</h2>
            </td>
        </tr>
    `);
}