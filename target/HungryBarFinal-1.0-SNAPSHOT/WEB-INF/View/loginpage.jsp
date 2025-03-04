<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login - Hungry Bar</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/lucide-static@0.16.0/font/lucide.css" rel="stylesheet">
    <script src="https://unpkg.com/lucide@latest"></script>
    <script>
  // Initialize Lucide Icons after the library is loaded
  lucide.createIcons();
</script>
    
</head>
<body class="min-h-screen bg-gray-50 flex items-center justify-center p-4">
    <div class="max-w-md w-full bg-white rounded-lg shadow-lg p-8">
        <div class="flex flex-col items-center mb-8">
            <div class="h-12 w-12 bg-red-500 rounded-full flex items-center justify-center mb-4">
                <i data-lucide="pizza" class="text-white h-8 w-8"></i>
            </div>
            <h1 class="text-2xl font-bold text-gray-900">Hungry Bar</h1>
            <p class="text-gray-500 mt-2">Sign in to order your pizza</p>
        </div>
        <form action="login" method="post" class="space-y-6">
            <div>
                <label for="Email" class="block text-sm font-medium text-gray-700 mb-1">
                    Email
                </label>
                <input id="email" name="email" type="email" required
                       class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-red-500 focus:border-red-500">
            </div>
            <div>
                <label for="password" class="block text-sm font-medium text-gray-700 mb-1">
                    Password
                </label>
                <div class="relative">
                    <input id="password" name="password" type="password" required
                           class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-red-500 focus:border-red-500">
                    <button type="button" onclick="togglePasswordVisibility()"
                            class="absolute right-3 top-1/2 transform -translate-y-1/2 text-gray-500 hover:text-gray-700">
                        <i id="eye-icon" class="fas fa-eye"></i>
                    </button>
                </div>
            </div>
            <div class="flex items-center justify-between">
                <div class="flex items-center">
                    <input id="remember-me" name="remember-me" type="checkbox"
                           class="h-4 w-4 text-red-500 focus:ring-red-500 border-gray-300 rounded">
                    <label for="remember-me" class="ml-2 block text-sm text-gray-700">
                        Keep me logged in
                    </label>
                </div>
                <div class="text-sm">
                    <a href="#" class="text-red-500 hover:text-red-600">
                        Forgot password?
                    </a>
                </div>
            </div>
            <button type="submit"
                    class="w-full bg-red-500 text-white py-2 px-4 rounded-md hover:bg-red-600 focus:outline-none focus:ring-2 focus:ring-red-500 focus:ring-offset-2 transition-colors">
                Sign In
            </button>
            <div class="relative my-6">
                <div class="absolute inset-0 flex items-center">
                    <div class="w-full border-t border-gray-300"></div>
                </div>
                <div class="relative flex justify-center text-sm">
                    <span class="px-2 bg-white text-gray-500">
                        Or continue with
                    </span>
                </div>
            </div>
            <div class="grid grid-cols-3 gap-3">
                <button type="button"
                    class="flex justify-center items-center py-2 px-4 border border-gray-300 rounded-md shadow-sm bg-white hover:bg-gray-50 transition-colors">
                    <svg class="h-5 w-5" viewBox="0 0 24 24" fill="#EA4335">
                        <path d="M12 24c6.627 0 12-5.373 12-12S18.627 0 12 0 0 5.373 0 12s5.373 12 12 12zm0-2c-5.523 0-10-4.477-10-10S6.477 2 12 2s10 4.477 10 10-4.477 10-10 10zm0-15.5c2.459 0 4.731 1.172 6.152 3.04l-2.938 2.94C14.353 11.563 13.267 11 12 11c-2.206 0-4 1.794-4 4s1.794 4 4 4c1.267 0 2.353-.563 3.214-1.48l2.938 2.94C16.731 22.328 14.459 23.5 12 23.5c-4.687 0-8.5-3.813-8.5-8.5s3.813-8.5 8.5-8.5z" />
                    </svg>
                </button>
                <button type="button"
                    class="flex justify-center items-center py-2 px-4 border border-gray-300 rounded-md shadow-sm bg-white hover:bg-gray-50 transition-colors">
                    <i data-lucide="facebook" class="h-5 w-5 text-[#1877F2]"></i>
                </button>
                <button type="button"
                    class="flex justify-center items-center py-2 px-4 border border-gray-300 rounded-md shadow-sm bg-white hover:bg-gray-50 transition-colors">
                    <i data-lucide="instagram" class="h-5 w-5 text-[#E4405F]"></i>
                </button>
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/lucide-static@0.16.0/umd/lucide.min.js"></script>
    <script src="https://kit.fontawesome.com/your-fontawesome-kit.js" crossorigin="anonymous"></script>
    <script>
        lucide.createIcons();

        function togglePasswordVisibility() {
            const passwordInput = document.getElementById('password');
            const eyeIcon = document.getElementById('eye-icon');
            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                eyeIcon.setAttribute('data-lucide', 'eye-off');
            } else {
                passwordInput.type = 'password';
                eyeIcon.setAttribute('data-lucide', 'eye');
            }
            lucide.createIcons();
        }
    </script>
</body>
</html>