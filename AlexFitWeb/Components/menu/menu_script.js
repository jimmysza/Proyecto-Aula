
const checkbox = document.querySelector(".header__checkbox");

const navBox = document.querySelector(".container-cards__categories");

checkbox.addEventListener("click", () => {
    navBox.classList.toggle("hidden");
});



// Seleccionamos todos los elementos necesarios
const menuBtns = document.querySelectorAll(".btn-categoria:not(.btn-todos)"); // Excluimos el botón todos
const btnTodos = document.querySelector(".btn-todos"); // Seleccionamos el botón todos
// const menuContents = document.querySelectorAll(".menu-content");

// Función para mostrar todos los menús
function showAllMenus() {
    
    
    // Desactivar todos los botones de categoría
    menuBtns.forEach(btn => {
        btn.classList.remove("active");
    });
    
    // Activar solo el botón todos
    btnTodos.classList.add("active");
}

// Event listener para el botón "Todos"
if (btnTodos) {
    btnTodos.addEventListener("click", showAllMenus);
}

// Event listeners para los botones de categoría
menuBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
        // Desactivar el botón todos si existe
        if (btnTodos) {
            btnTodos.classList.remove("active");
        }
        
        // Remover la clase active de todos los botones de categoría
        menuBtns.forEach((b) => b.classList.remove("active"));
        
        // Agregar la clase active al botón clickeado
        btn.classList.add("active");

        // Ocultar todos los menús
        menuContents.forEach((content) => {
            content.classList.remove("active");
        });
        
        // Mostrar el menú correspondiente
        const menuId = btn.getAttribute("data-menu");
        const selectedMenu = document.getElementById(menuId);
        if (selectedMenu) {
            selectedMenu.classList.add("active");
        }
    });
});

// Inicializar mostrando todos los menús cuando carga la página
window.addEventListener('DOMContentLoaded', () => {
    showAllMenus();
});


document.addEventListener('DOMContentLoaded', () => {
    const hash = window.location.hash;
    if (hash) {
        document.querySelector(hash)?.classList.add('highlight'); // Agrega una clase especial
    }
});

