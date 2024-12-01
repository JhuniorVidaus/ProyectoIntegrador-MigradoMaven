function agregarAlCarrito(url) {
    Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Producto agregado al carrito',
        showConfirmButton: false,
        timer: 1500,
        height: '50px'
    });
    setTimeout(function () {
        window.location.href = url;
    }, 1500);
}
