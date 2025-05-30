class FlowerShopModel {
    constructor() {
        this.users = [];
        this.categories = [ /* ... */ ];
        this.products = [ /* ... */ ];
        this.cart = [];
        this.orders = [];
        this.currentUser = null;
    }

    registerUser(userData) {
        const newUser = { id: this.users.length + 1, ...userData, created_at: new Date(), is_active: true };
        this.users.push(newUser);
        return newUser;
    }

    loginUser(email, password) {
        const user = this.users.find(u => u.email === email && u.password === password);
        if (user) this.currentUser = user;
        return user || null;
    }

    // ... metode getProducts, getProductById, addToCart, removeFromCart, getCartItems, getCartTotal, clearCart, createOrder
}