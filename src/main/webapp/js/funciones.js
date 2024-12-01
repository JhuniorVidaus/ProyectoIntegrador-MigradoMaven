$(document).ready(function () {
    console.log('ready')
    // Cambié "tr #btnDelete" a "tr a#btnDelete" para seleccionar correctamente el enlace con id "btnDelete"
    $("tr a#btnDelete").click(function (event) {
        event.preventDefault(); // Previene el comportamiento predeterminado del enlace
        var idp = $(this).closest('td').find("#idp").val(); // Cambié parent().find a closest('td').find
        swal({
            title: "Desea eliminar este producto?",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then((willDelete) => {
            if (willDelete) {
                eliminar(idp);
                swal("Producto Eliminado!", {
                    icon: "success",
                }).then(() => { // Corregí la sintaxis de then
                    parent.location.href = "ControladorCarrito01?accion=Carrito";
                });
            } else {
                swal("No se elimino el producto!");
            }
        });
    });

    function eliminar(idp) {
        var url = "ControladorCarrito01?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp,
            success: function (data, textStatus, jqXHR) {
                // Manejo del éxito
            }
        });
    }

    // Cambié el evento de click a change para detectar cambios en el input de cantidad
    $("tr #Cantidad").change(function () {
        var idp = $(this).closest('td').find("#idpro").val(); // Cambié parent().find a closest('td').find
        var cantidad = $(this).val();
        var url = "ControladorCarrito01?accion=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp + "&Cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
                location.href = "ControladorCarrito01?accion=Carrito";
            }
        });
    });
});