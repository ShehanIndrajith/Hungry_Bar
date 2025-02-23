<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register - Hungry Bar</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <script>
        function togglePasswordVisibility(fieldId, iconId) {
            const passwordInput = document.getElementById(fieldId);
            const eyeIcon = document.getElementById(iconId);
            if (passwordInput.type === "password") {
                passwordInput.type = "text";
                eyeIcon.classList.remove("fa-eye");
                eyeIcon.classList.add("fa-eye-slash");
            } else {
                passwordInput.type = "password";
                eyeIcon.classList.remove("fa-eye-slash");
                eyeIcon.classList.add("fa-eye");
            }
        }

        function validatePassword() {
            const password = document.getElementById("password").value;
            const confirmPassword = document.getElementById("confirmPassword").value;

            if (password !== confirmPassword) {
                document.getElementById("passwordError").innerText = "Passwords do not match!";
                return false; // Prevent form submission
            } else {
                document.getElementById("passwordError").innerText = ""; // Clear error message
                return true; // Allow form submission
            }
        }
    </script>
</head>
<body class="min-h-screen bg-gray-50 flex items-center justify-center p-4">
    <div class="max-w-md w-full bg-white rounded-lg shadow-lg p-8">
        <div class="flex flex-col items-center mb-8">
            <div class="h-12 w-12 bg-red-500 rounded-full flex items-center justify-center mb-4">
                <i class="fas fa-pizza-slice text-white text-2xl"></i>
            </div>
            <h1 class="text-2xl font-bold text-gray-900">Create Account</h1>
            <p class="text-gray-500 mt-2">Sign up to start ordering</p>
        </div>
        <form action="register" method="post" onsubmit="return validatePassword()" class="space-y-6">
            <div>
                <label for="username" class="block text-sm font-medium text-gray-700 mb-1">
                    Username
                </label>
                <input id="name" name="name" type="text" required
                       class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-red-500 focus:border-red-500">
            </div>
            <div>
                <label for="email" class="block text-sm font-medium text-gray-700 mb-1">
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
                    <button type="button" onclick="togglePasswordVisibility('password', 'password-eye-icon')"
                            class="absolute right-3 top-1/2 transform -translate-y-1/2 text-gray-500 hover:text-gray-700">
                        <i id="password-eye-icon" class="fas fa-eye"></i>
                    </button>
                </div>
            </div>
            <div>
                <label for="confirmPassword" class="block text-sm font-medium text-gray-700 mb-1">
                    Confirm Password
                </label>
                <div class="relative">
                    <input id="confirmPassword" name="confirmPassword" type="password" required
                           class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-red-500 focus:border-red-500">
                    <button type="button" onclick="togglePasswordVisibility('confirmPassword', 'confirmPassword-eye-icon')"
                            class="absolute right-3 top-1/2 transform -translate-y-1/2 text-gray-500 hover:text-gray-700">
                        <i id="confirmPassword-eye-icon" class="fas fa-eye"></i>
                    </button>
                </div>
            </div>
            <div class="flex justify-center text-sm">
                <p class="text-gray-600">
                    Already have an account?{" "}
                    <a href="login.jsp" class="text-red-500 hover:text-red-600 font-medium">
                        Sign in
                    </a>
                </p>
            </div>
            <button type="submit"
                    class="w-full bg-red-500 text-white py-2 px-4 rounded-md hover:bg-red-600 focus:outline-none focus:ring-2 focus:ring-red-500 focus:ring-offset-2 transition-colors">
                Create Account
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
                    <i class="fab fa-google text-red-500"></i>
                </button>
                <button type="button"
                        class="flex justify-center items-center py-2 px-4 border border-gray-300 rounded-md shadow-sm bg-white hover:bg-gray-50 transition-colors">
                    <i class="fab fa-facebook text-blue-600"></i>
                </button>
                <button type="button"
                        class="flex justify-center items-center py-2 px-4 border border-gray-300 rounded-md shadow-sm bg-white hover:bg-gray-50 transition-colors">
                    <i class="fab fa-instagram text-pink-600"></i>
                </button>
            </div>
        </form>
        <p id="passwordError" class="text-red-500 text-sm mt-2"></p>
        <p class="text-red-500 text-sm mt-2">${errorMessage}</p>
    </div>
    <script src="https://kit.fontawesome.com/your-fontawesome-kit.js" crossorigin="anonymous"></script>
</body>
</html>