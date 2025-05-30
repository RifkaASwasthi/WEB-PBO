class FlowerShopController {
    constructor() {
        this.model = new FlowerShopModel();
        this.view = new FlowerShopView();
        this.init();
    }

    init() {
        this.view.renderCategories(this.model.getCategories());
        this.view.renderProducts(this.model.getProducts());
        this.updateCartCount();
        this.setupEventListeners();
    }

    setupEventListeners() {
        document.getElementById('loginForm').addEventListener('submit', e => { e.preventDefault(); this.handleLogin(); });
        document.getElementById('registerForm').addEventListener('submit', e => { e.preventDefault(); this.handleRegister(); });
    }

    handleLogin() { /* login logic */ }
    handleRegister() { /* register logic */ }
    addToCart(id, qty = 1) { /* tambah ke cart */ }
    removeFromCart(id) { /* hapus dari cart */ }
    updateCartCount() { const total = this.model.getCartItems().reduce((sum, i) => sum + i.quantity, 0); this.view.updateCartCount(total); }
    renderCartItems() { this.view.renderCartItems(this.model.getCartItems(), this.model.getCartTotal()); }
    checkout() { /* checkout logic */ }
    filterByCategory(id) { this.view.renderProducts(this.model.getProducts(id)); }
    searchProducts(q) { const p = this.model.getProducts().filter(i => i.name.toLowerCase().includes(q.toLowerCase())); this.view.renderProducts(p); }
    logout() { this.model.currentUser = null; this.model.clearCart(); this.updateCartCount(); this.view.logout(); this.view.showNotification('Berhasil logout!', 'info'); }
}
