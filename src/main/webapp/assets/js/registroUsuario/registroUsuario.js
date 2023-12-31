$(document).ready(function () {
    $("#btn-grabar").on('click', function () {
        let data = {
            apellidos: $("#in-apellidos").val(),
            nombre: $("#in-nombre").val(),
            dni: $("#in-dni").val(),
            usuario: $("#in-usuario").val(),
            password: $("#in-password").val(),
            rpassword: $("#in-repeat-password").val(),
            evento: 'registrar-usuario'
        };

        if (datosValidos(data)) {
            $.ajax({
                url: "../../RegistroUsuarioController",
                type: 'POST',
                dataType: 'json',
                data: data,
                beforeSend: function (xhr) {
                    $.LoadingOverlay("show");
                },
                success: function (response) {
                    if (response.css == 'danger') {
                        toastr.error(response.data, 'Error al registrar usuario');
                    }

                    if (response.css == 'success') {
                        toastr.success(response.data, 'Usuario registrado correctamente');
                        limpiarCampos();
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    toastr.error('Ocuriro un error al registrar al nuevo usuario', 'Error interno');
                },
                complete: function (jqXHR, textStatus) {
                    $.LoadingOverlay("hide");
                }
            });
        }
    });
});

const datosValidos = (data) => {
    let errorFound = false;
    $.each(data, function (key, value) {
        if (!value) {
            toastr.error('El campo ' + key + ' es obligatorio', 'Completa los datos');
            errorFound = true;
        }
    });

    if (data.password !== data.rpassword) {
        toastr.error('Contraseña diferente', 'Error de Contraseña');
        errorFound = true;
    }

    return !errorFound;
};

function limpiarCampos() {
    $("#in-apellidos").val('');
    $("#in-nombre").val('');
    $("#in-dni").val('');
    $("#in-usuario").val('');
    $("#in-password").val('');
    $("#in-repeat-password").val('');
}
