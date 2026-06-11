# 🎵 Paito Eventos

Paito Eventos es una plataforma web que conecta clientes que necesitan música para sus eventos con músicos, agrupaciones, orquestas, bandas y DJs disponibles para ser contratados.

La plataforma busca facilitar el proceso de búsqueda, contratación y gestión de servicios musicales para todo tipo de eventos, comenzando en Cúcuta y con proyección a expandirse a toda Colombia.

---

## 🚀 Objetivo

Crear una plataforma digital que permita a los clientes encontrar y contratar servicios musicales de manera rápida, segura y organizada, mientras los artistas pueden promocionar sus servicios y gestionar sus contrataciones.

---

## 👥 Tipos de Usuarios

### Cliente

Personas que buscan contratar servicios musicales para:

* Cumpleaños
* Matrimonios
* Serenatas
* Eventos empresariales
* Eventos religiosos
* Fiestas privadas
* Otros eventos

#### Funcionalidades

* Registro e inicio de sesión.
* Búsqueda de músicos y agrupaciones.
* Filtrado por categoría, ubicación y tipo de servicio.
* Visualización de perfiles profesionales.
* Creación de solicitudes de contratación.
* Seguimiento de solicitudes realizadas.
* Calificación y comentarios sobre servicios contratados.

---

### Músico / Agrupación

Incluye:

* Músicos solistas
* Agrupaciones musicales
* Orquestas
* Bandas
* DJs

#### Funcionalidades

* Registro e inicio de sesión.
* Creación y edición de perfil profesional.
* Publicación de fotografías y videos.
* Gestión de paquetes de servicios.
* Recepción de solicitudes de contratación.
* Aceptación o rechazo de solicitudes.
* Administración de disponibilidad.
* Visualización de calificaciones y comentarios.

---

### Administrador

#### Funcionalidades

* Gestión de usuarios.
* Gestión de músicos y agrupaciones.
* Supervisión de contrataciones.
* Gestión de categorías musicales.
* Moderación de contenido.
* Generación de estadísticas y reportes.
* Bloqueo o suspensión de cuentas.

---

## 📋 Modelo de Contratación

Los clientes podrán crear solicitudes detalladas indicando:

* Tipo de evento.
* Fecha.
* Hora.
* Dirección.
* Cantidad estimada de asistentes.
* Presupuesto.
* Descripción personalizada.

Los músicos podrán visualizar las solicitudes y responder según su disponibilidad.

---

## 🎼 Paquetes de Servicios

Los músicos podrán ofrecer diferentes paquetes, por ejemplo:

* 1 hora.
* 2 horas.
* 4 horas.
* Evento completo.

Cada paquete incluirá:

* Precio.
* Duración.
* Descripción.
* Servicios incluidos.

---

## ⭐ Sistema de Calificaciones

Después de cada contratación, los clientes podrán:

* Calificar de 1 a 5 estrellas.
* Escribir comentarios.
* Consultar opiniones de otros usuarios.

---

## 📸 Portafolio Multimedia

Los músicos podrán mostrar su trabajo mediante:

* Fotografías.
* Videos.
* Información profesional.
* Experiencia artística.

---

## 🎯 Alcance Inicial

La primera versión de Paito Eventos estará enfocada en la ciudad de Cúcuta.

Posteriormente se proyecta expandir la plataforma a nivel nacional en Colombia.

---

## 💰 Modelo de Negocio

Paito Eventos buscará generar ingresos mediante:

* Comisiones por contratación realizada.
* Servicios premium para músicos.
* Promoción destacada de perfiles.
* Publicidad y alianzas estratégicas.

---

## 🛠️ Tecnologías Planeadas

### Backend

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* JWT

### Base de Datos

* MySQL

### Herramientas

* Maven
* Git
* GitHub
* Postman
* Swagger

---

## 📌 Estado del Proyecto

🚧 Fase de análisis y diseño funcional.


Fases de Desarrollo

FASE 1 - ANÁLISIS

Objetivo:
Conectar clientes que necesitan música para eventos con músicos disponibles.

Roles:

Cliente
Músico
Administrador (opcional)

FASE 2 - CASOS DE USO

Cliente:

Registrarse
Iniciar sesión
Buscar músicos
Ver perfil de músico
Solicitar contratación
Ver solicitudes realizadas

Músico:

Registrarse
Crear perfil musical
Editar perfil
Aceptar solicitudes
Rechazar solicitudes

FASE 3 - DISEÑO DE INTERFACES

Pantallas:

Login
Registro
Inicio
Lista de músicos
Perfil de músico
Crear solicitud
Mis solicitudes
Panel del músico

FASE 4 - MODELO DE DOMINIO

Entidades principales:

Usuario
Músico
Instrumento
Solicitud
Evento

FASE 5 - BASE DE DATOS MYSQL

Crear el modelo relacional una vez estén definidas todas las entidades y relaciones.

FASE 6 - BACKEND SPRING BOOT

Configurar proyecto
Configurar MySQL
Configurar JPA
Configurar Security
Configurar JWT

FASE 7 - IMPLEMENTACIÓN

Registro
Login
CRUD de músicos
Búsqueda de músicos
Solicitudes
Aceptar/Rechazar solicitudes

FASE 8 - PRUEBAS

Postman
Validaciones
Seguridad

FASE 9 - DOCUMENTACIÓN

Swagger
README
Diagrama de clases
Diagrama entidad-relación

Arquitectura Hexagonal (Ports & Adapters)

paito-eventos
│
├── domain
├── application
├── infrastructure
├── presentation
└── config

Desglose de cada carpeta

Domain

Aquí está la lógica del negocio.

domain
│
├── model
│   ├── Usuario.java
│   ├── Musico.java
│   ├── Solicitud.java
│   └── Instrumento.java
│
├── repository
│   ├── UsuarioRepository.java
│   ├── MusicoRepository.java
│   └── SolicitudRepository.java
│
└── enums
    ├── Rol.java
    └── EstadoSolicitud.java

Aquí NO va código de Spring.

7. Application

Contiene los casos de uso.

application
│
├── usecase
│   ├── RegistrarUsuarioUseCase.java
│   ├── LoginUseCase.java
│   ├── BuscarMusicosUseCase.java
│   ├── CrearSolicitudUseCase.java
│   ├── AceptarSolicitudUseCase.java
│   └── RechazarSolicitudUseCase.java
│
└── service
8. Infrastructure

Implementa la conexión con MariaDB.

infrastructure
│
├── persistence
│   ├── entity
│   │   ├── UsuarioEntity.java
│   │   ├── MusicoEntity.java
│   │   └── SolicitudEntity.java
│   │
│   ├── repository
│   │   ├── JpaUsuarioRepository.java
│   │   ├── JpaMusicoRepository.java
│   │   └── JpaSolicitudRepository.java
│   │
│   └── adapter
│       ├── UsuarioRepositoryAdapter.java
│       ├── MusicoRepositoryAdapter.java
│       └── SolicitudRepositoryAdapter.java
9. Presentation

API REST.

presentation
│
├── controller
│   ├── AuthController.java
│   ├── UsuarioController.java
│   ├── MusicoController.java
│   └── SolicitudController.java
│
├── dto
│   ├── request
│   └── response
│
└── mapper
10. Config

Configuraciones globales.

config
│
├── SecurityConfig.java
├── JwtConfig.java
└── SwaggerConfig.java
