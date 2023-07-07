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

function procederCompra() {
    let cliente = {
        dni: $("#txt_dni").val(),
        nroPersonas: $("#txt_nro_personas").val(),
        nombres: $("#txt_nombres").val(),
        apellidos: $("#txt_apellidos").val(),
        correo: $("#txt_correo").val()
    };

    localStorage.setItem("clienteBD", JSON.stringify(cliente));
    location.href = '../voucher/voucher.jsp';
}

function registrarCliente() {
    $.ajax({
        type: 'POST',
        url: "../../ClienteController?accion=registrar",
        data: {
            nombres: $("#txt_nombres").val(),
            apellidos: $("#txt_apellidos").val(),
            dni: $("#txt_dni").val(),
            correo: $("#txt_correo").val()
        },
        success: function (data, textStatus, jqXHR) {
            if (data == "1") {
                toastr.success('Cliente registrado correctamente', 'Mensaje exitoso');
            } else {
                toastr.error('No pudo registrar el cliente', 'Error');
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición registrarCliente', 'Error interno');
        }
    });
}