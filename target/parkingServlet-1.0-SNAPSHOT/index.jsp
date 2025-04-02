<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>TechAssist - Registrarse</title>

        <!-- Tailwind CSS -->
        <script src="https://cdn.tailwindcss.com"></script>

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap" rel="stylesheet">

        <!-- FontAwesome Icons -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">

        <link href="css/register.css" rel="stylesheet">
    </head>

    <body class="font-nunito">
        <!-- Líneas decorativas -->
        <div class="line"></div>
        <div class="line"></div>
        <div class="line"></div>

        <div class="flex bg-[#C01E2B] items-center justify-center min-h-screen">
            <div class="bg-white shadow-xl rounded-lg w-full max-w-lg p-8">
                <!-- Título -->
                <div class="flex flex-col items-center justify-center text-center mb-6">
                    <img src="images/LogoPpal.png" alt="Logo TechAssist" class="w-14 h-14 mb-6 animate-pulse relative z-10">
                    <h1 class="text-3xl font-bold text-gray-800">Crear Cuenta en ParkingPro</h1>
                    <p class="text-gray-600 text-sm">Completa el formulario para crear tu cuenta y comenzar a gestionar tus tickets.</p>
                </div>

                <!-- Bloque para mostrar errores -->
                <% if (request.getAttribute("error") != null) {%>
                <div class="bg-red-100 text-red-700 border border-red-400 rounded-md p-3 mb-4">
                    <p><%= request.getAttribute("error")%></p>
                </div>
                <% }%>


                <form action="SvClientes" method="POST">
                    <div class="space-y-4">
                        <!-- Username and Phone -->
                        <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
                            <div>
                                <label for="username" class="block text-sm font-medium text-gray-700">Nombre completo</label>
                                <input 
                                    type="text" 
                                    id="fullname" 
                                    name="fullname" 
                                    placeholder="Nombre completo" 
                                    class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 text-gray-800 placeholder-gray-400"
                                    required
                                    >
                            </div>
                            <div>
                                <label for="telefono" class="block text-sm font-medium text-gray-700">Teléfono</label>
                                <input 
                                    type="tel" 
                                    id="phone" 
                                    name="phone" 
                                    placeholder="Teléfono" 
                                    class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 text-gray-800 placeholder-gray-400" 
                                    required 
                                    pattern="[0-9]{8,15}" 
                                    title="El teléfono debe contener entre 8 y 15 dígitos"
                                    >
                            </div>
                        </div>

                        <!-- Email -->
                        <div>
                            <label for="email" class="block text-sm font-medium text-gray-700">Correo Electrónico</label>
                            <input 
                                type="email" 
                                id="email" 
                                name="email" 
                                placeholder="Correo Electrónico" 
                                class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 text-gray-800 placeholder-gray-400" 
                                required
                                >
                        </div>

                        <!-- Hidden ID Role -->
                        <input type="hidden" name="idrol" value="3">

                        <!-- Submit Button -->
                        <button 
                            type="submit" 
                            class="w-full bg-indigo-600 hover:bg-indigo-500 text-white font-bold py-3 px-6 rounded-lg shadow-md transition duration-300 transform hover:scale-105"
                            >
                            Registrar Cuenta
                        </button>
                    </div>
                </form>

                <hr class="my-6 border-gray-300">
            </div>
        </div>
    </body>
</html>
