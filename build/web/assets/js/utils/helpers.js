function openModal(id) { document.getElementById(id).style.display = 'block'; }
function closeModal(id) { document.getElementById(id).style.display = 'none'; }
function toggleCart() { app.renderCartItems(); openModal('cartModal'); }
function checkout() { app.checkout(); }
function performSearch() {
    const q = document.getElementById('searchInput').value;
    if (q.trim()) {
        app.searchProducts(q);
        document.getElementById('products').scrollIntoView({ behavior: 'smooth' });
    }
}
window.addEventListener('load', () => {
    const header = document.querySelector('.header');
    const searchBar = document.createElement('div');
    searchBar.innerHTML = `<div style="display: flex; gap: 0.5rem; margin-top: 1rem;"><input type="text" id="searchInput" placeholder="Cari bunga..." style="flex: 1; padding: 0.5rem; border: none; border-radius: 5px;"><button onclick="performSearch()" class="btn btn-primary">🔍</button></div>`;
    header.querySelector('.container').appendChild(searchBar);
    document.addEventListener('keypress', e => {
        if (e.key === 'Enter' && document.activeElement.id === 'searchInput') performSearch();
    });
});

// 📄 app.js (web/assets/js/app.js)
let app;
document.addEventListener('DOMContentLoaded', () => {
    app = new FlowerShopController();
});
