
function saveScrollPosition() {
    localStorage.setItem('scrollPosition', window.scrollY);
}

window.addEventListener('beforeunload', saveScrollPosition);

function restoreScrollPosition() {
    const scrollPosition = localStorage.getItem('scrollPosition');
    if (scrollPosition !== null) {
        window.scrollTo(0, parseInt(scrollPosition, 10));
    }
}
window.addEventListener('load', restoreScrollPosition);
