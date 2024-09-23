import { useState, useEffect } from 'react'
import { Button } from "@/components/ui/button"
import { Card, CardContent } from "@/components/ui/card"
import { Leaf, Burger, Dumbbell } from "lucide-react"

lucide.createIcons();
        
        window.addEventListener('scroll', function() {
            var header = document.getElementById('header');
            if (window.scrollY === 0) {
                header.classList.add('translate-y-0', 'bg-white', 'shadow-md');
                header.classList.remove('-translate-y-full');
            } else {
                header.classList.remove('translate-y-0', 'bg-white', 'shadow-md');
                header.classList.add('-translate-y-full');
            }
        });
        
window.addEventListener('scroll', function() {
    var navbar = document.getElementById('.header');
    var contentTop = document.getElementById('.Links').getBoundingClientRect().top;

    if (contentTop <= 0) {  // Si la posición del contenido llega al top
        navbar.classList.add('show');
    } else {
        navbar.classList.remove('show');
    }
});
