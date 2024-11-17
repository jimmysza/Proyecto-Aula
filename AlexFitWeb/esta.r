# Cargar los datos
household <- 1:40
amount <- c(555,489,458,613,647,661,662,675,549,606,668,740,592,720,680,540,693,541,673,676,913,918,710,1083,937,839,1030,1065,1069,1064,1015,1148,1125,1090,1208,1217,1140,1265,1206,1145)
income <- c(4388,4558,4793,4856,4856,4899,4899,5091,5133,5304,5304,5304,5346,5495,5581,5730,5943,5943,6156,6603,6688,6752,6837,7242,7263,7540,8009,8094,8264,8392,8414,8882,8925,8989,9053,9138,9329,9649,9862,9883)

# Crear el dataframe
data <- data.frame(household, amount, income)

# Realizar el análisis de regresión
modelo <- lm(amount ~ income, data=data)

# Resumen del modelo
summary(modelo)

# Gráfico de dispersión con línea de regresión
plot(income, amount, 
     main="Gasto en Comestibles vs Ingreso",
     xlab="Ingreso ($)",
     ylab="Gasto en Comestibles ($)",
     pch=19)
abline(modelo, col="red")

# Calcular intervalo de confianza para los coeficientes
confint(modelo, level=0.95)

# Diagnósticos del modelo
par(mfrow=c(2,2))
plot(modelo)

# Estadísticas descriptivas
summary(amount)
summary(income)
cor(amount, income)

# Prueba de normalidad
shapiro.test(residuals(modelo))