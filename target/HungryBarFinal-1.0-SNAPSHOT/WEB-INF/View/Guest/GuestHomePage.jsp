<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Hungry Bar - Guest Home Page</title>
  <!-- Tailwind CSS CDN -->
  <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
  <!-- Lucide Icons CDN -->
  <link href="https://cdn.jsdelivr.net/npm/lucide-static@0.16.0/font/lucide.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/lucide@latest"></script>
    <script>
  // Initialize Lucide Icons after the library is loaded
  lucide.createIcons();
</script>
</head>
<body class="flex flex-col">
  <!-- Header -->
  <header class="fixed top-0 left-0 right-0 bg-white shadow-sm z-50">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="flex justify-between items-center h-16">
        <div class="flex items-center">
          <div class="flex-shrink-0">
            <div class="flex items-center">
              <i data-lucide="pizza" class="h-8 w-8 text-red-500"></i>
              <span class="ml-2 text-xl font-bold text-gray-900">Hungry Bar</span>
            </div>
          </div>
        </div>
        <nav class="hidden md:flex space-x-8">
          <a href="#" class="text-gray-700 hover:text-gray-900">Home</a>
          <a href="#" class="text-gray-700 hover:text-gray-900">Menu</a>
          <a href="#" class="text-gray-700 hover:text-gray-900">About Us</a>
          <a href="#" class="text-gray-700 hover:text-gray-900">Contact</a>
        </nav>
        <div class="hidden md:flex items-center space-x-4">
          <button class="p-2 hover:bg-gray-100 rounded-full">
            <i data-lucide="shopping-cart" class="h-5 w-5"></i>
          </button>
          <button class="px-4 py-2 text-gray-700 hover:text-gray-900">Login</button>
          <button class="px-4 py-2 bg-red-500 text-white rounded-lg hover:bg-red-600">Sign Up</button>
        </div>
        <button id="mobile-menu-button" class="md:hidden p-2">
          <i data-lucide="menu" class="h-6 w-6"></i>
        </button>
      </div>
    </div>
    <!-- Mobile Navigation Menu -->
    <div id="mobile-menu" class="hidden md:hidden">
      <div class="px-2 pt-2 pb-3 space-y-1">
        <a href="#" class="block px-3 py-2 text-gray-700">Home</a>
        <a href="#" class="block px-3 py-2 text-gray-700">Menu</a>
        <a href="#" class="block px-3 py-2 text-gray-700">About Us</a>
        <a href="#" class="block px-3 py-2 text-gray-700">Contact</a>
        <a href="#" class="block px-3 py-2 text-gray-700">Login</a>
        <a href="#" class="block px-3 py-2 text-gray-700">Sign Up</a>
      </div>
    </div>
  </header>

  <!-- Hero Section -->
  <div class="relative h-[600px] flex items-center justify-center text-white">
    <div class="absolute inset-0">
      <img src="https://images.unsplash.com/photo-1513104890138-7c749659a591" alt="Pizza background" class="w-full h-full object-cover" />
      <div class="absolute inset-0 bg-black opacity-50"></div>
    </div>
    <div class="relative z-10 text-center px-4">
      <h1 class="text-4xl md:text-6xl font-bold mb-4">
        Craving the Best Pizza?<br />We've Got You Covered!
      </h1>
      <p class="text-xl md:text-2xl mb-8">
        Explore a variety of pizzas, burgers, and more from top restaurants near you.
      </p>
      <div class="max-w-2xl mx-auto">
        <div class="relative">
          <input type="text" placeholder="Search for your favorite pizza..." class="w-full px-6 py-4 rounded-full text-gray-900 text-lg focus:outline-none focus:ring-2 focus:ring-red-500" />
          <button class="absolute right-2 top-1/2 transform -translate-y-1/2 p-2 bg-red-500 rounded-full hover:bg-red-600">
            <i data-lucide="search" class="h-6 w-6"></i>
          </button>
        </div>
      </div>
    </div>
  </div>

  <!-- Categories Section -->
  <section class="py-16 bg-white">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <h2 class="text-3xl font-bold text-center mb-12">Our Categories</h2>
      <div class="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-6 gap-8">
        <div class="flex flex-col items-center p-6 rounded-lg hover:shadow-lg transition-shadow cursor-pointer">
          <span class="text-4xl mb-4">🍕</span>
          <h3 class="text-lg font-semibold">Pizza</h3>
        </div>
        <div class="flex flex-col items-center p-6 rounded-lg hover:shadow-lg transition-shadow cursor-pointer">
          <span class="text-4xl mb-4">🍔</span>
          <h3 class="text-lg font-semibold">Burgers</h3>
        </div>
        <div class="flex flex-col items-center p-6 rounded-lg hover:shadow-lg transition-shadow cursor-pointer">
          <span class="text-4xl mb-4">🥗</span>
          <h3 class="text-lg font-semibold">Salads</h3>
        </div>
        <div class="flex flex-col items-center p-6 rounded-lg hover:shadow-lg transition-shadow cursor-pointer">
          <span class="text-4xl mb-4">🍰</span>
          <h3 class="text-lg font-semibold">Desserts</h3>
        </div>
        <div class="flex flex-col items-center p-6 rounded-lg hover:shadow-lg transition-shadow cursor-pointer">
          <span class="text-4xl mb-4">🥤</span>
          <h3 class="text-lg font-semibold">Drinks</h3>
        </div>
        <div class="flex flex-col items-center p-6 rounded-lg hover:shadow-lg transition-shadow cursor-pointer">
          <span class="text-4xl mb-4">🍟</span>
          <h3 class="text-lg font-semibold">Sides</h3>
        </div>
      </div>
    </div>
  </section>

  <!-- Featured Restaurants Section -->
  <section class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-16">
    <h2 class="text-3xl font-bold text-gray-900 mb-8">Our Pizza Categories</h2>
    <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8">
      <div class="bg-white rounded-lg shadow-lg overflow-hidden">
        <img src="https://images.unsplash.com/photo-1574071318508-1cdbab80d002" alt="Popular Pizza" class="w-full h-48 object-cover" />
        <div class="p-4">
          <div class="flex items-center justify-between mb-2">
            <h3 class="text-lg font-semibold">Pepperoni Supreme</h3>
            <span class="text-red-500 font-bold">$18.99</span>
          </div>
          <p class="text-gray-600 text-sm mb-4">Classic pepperoni with extra cheese</p>
          <button class="w-full bg-red-500 text-white py-2 rounded-md hover:bg-red-600 transition-colors">Add to Cart</button>
        </div>
      </div>
    </div>
  </section>

  <!-- Special Offers Section -->
  <div class="bg-gray-50 py-16">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <h2 class="text-3xl font-bold text-gray-900 mb-8">Special Offers</h2>
      <div class="grid grid-cols-1 md:grid-cols-2 gap-8">
        <div class="bg-white rounded-lg shadow-lg p-6 flex items-center">
          <div class="flex-1">
            <h3 class="text-xl font-bold mb-2">Family Weekend Deal</h3>
            <p class="text-gray-600 mb-4">Get 2 Large Pizzas + 2 Sides + 4 Drinks</p>
            <span class="text-2xl font-bold text-red-500 block mb-4">$49.99</span>
            <button class="bg-red-500 text-white px-6 py-2 rounded-md hover:bg-red-600 transition-colors">Order Now</button>
          </div>
          <div class="hidden md:block w-1/3">
            <img src="https://images.unsplash.com/photo-1534308983496-4fabb1a015ee" alt="Deal" class="w-full h-32 object-cover rounded-lg" />
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- How It Works Section -->
  <section class="py-16 bg-white">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <h2 class="text-3xl font-bold text-center mb-12">How It Works</h2>
      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8">
        <div class="flex flex-col items-center text-center">
          <i data-lucide="search" class="w-12 h-12 text-red-500 mb-4"></i>
          <h3 class="text-xl font-semibold mb-2">Browse</h3>
          <p class="text-gray-600">Explore restaurants & menus</p>
        </div>
        <div class="flex flex-col items-center text-center">
          <i data-lucide="shopping-cart" class="w-12 h-12 text-red-500 mb-4"></i>
          <h3 class="text-xl font-semibold mb-2">Order</h3>
          <p class="text-gray-600">Add items & customize</p>
        </div>
        <div class="flex flex-col items-center text-center">
          <i data-lucide="credit-card" class="w-12 h-12 text-red-500 mb-4"></i>
          <h3 class="text-xl font-semibold mb-2">Pay</h3>
          <p class="text-gray-600">Select payment method & confirm</p>
        </div>
        <div class="flex flex-col items-center text-center">
          <i data-lucide="package" class="w-12 h-12 text-red-500 mb-4"></i>
          <h3 class="text-xl font-semibold mb-2">Enjoy</h3>
          <p class="text-gray-600">Track order & receive delivery</p>
        </div>
      </div>
    </div>
  </section>

  <!-- Footer -->
  <footer class="bg-gray-900 text-white">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-12">
      <div class="grid grid-cols-1 md:grid-cols-4 gap-8">
        <div>
          <h3 class="text-xl font-bold mb-4">Hungry Bar</h3>
          <p class="text-gray-400">Delicious food delivered to your doorstep</p>
        </div>
        <div>
          <h4 class="font-semibold mb-4">Quick Links</h4>
          <ul class="space-y-2">
            <li><a href="#" class="text-gray-400 hover:text-white">About Us</a></li>
            <li><a href="#" class="text-gray-400 hover:text-white">Contact Us</a></li>
            <li><a href="#" class="text-gray-400 hover:text-white">Terms & Conditions</a></li>
            <li><a href="#" class="text-gray-400 hover:text-white">Privacy Policy</a></li>
          </ul>
        </div>
        <div>
          <h4 class="font-semibold mb-4">Contact Info</h4>
          <ul class="space-y-2 text-gray-400">
            <li>Email: info@hungrybar.com</li>
            <li>Phone: (555) 123-4567</li>
            <li>Address: 123 Food Street, NY</li>
          </ul>
        </div>
        <div>
          <h4 class="font-semibold mb-4">Follow Us</h4>
          <div class="flex space-x-4">
            <a href="#" class="hover:text-red-500"><i data-lucide="facebook"></i></a>
            <a href="#" class="hover:text-red-500"><i data-lucide="instagram"></i></a>
            <a href="#" class="hover:text-red-500"><i data-lucide="twitter"></i></a>
          </div>
        </div>
      </div>
      <div class="border-t border-gray-800 mt-8 pt-8 text-center text-gray-400">
        <p>&copy; 2024 Hungry Bar. All rights reserved.</p>
      </div>
    </div>
  </footer>

  <!-- JavaScript for Mobile Menu Toggle -->
  <script>
    document.getElementById('mobile-menu-button').addEventListener('click', function () {
      const mobileMenu = document.getElementById('mobile-menu');
      mobileMenu.classList.toggle('hidden');
    });
  </script>
</body>
</html>