class FlowerShopView {
    constructor() { this.setupGlobalEventListeners(); }

    setupGlobalEventListeners() { /* event listener untuk modal & scroll */ }

    renderCategories(categories) { /* render kategori */ }
    renderProducts(products) { /* render produk */ }
    renderCartItems(cartItems, total) { /* tampilkan keranjang */ }
    updateCartCount(count) { document.getElementById('cartCount').textContent = count; }

    showNotification(message, type = 'info') { /* notifikasi */ }
    openModal(id) { document.getElementById(id).style.display = 'block'; }
    closeModal(id) { document.getElementById(id).style.display = 'none'; }

    showLoading(formId) { /* loading button */ }
    hideLoading(formId) { /* selesai loading */ }
    updateUserInterface(user) { /* tampilkan nama user */ }
    logout() { /* reset tampilan */ }
}