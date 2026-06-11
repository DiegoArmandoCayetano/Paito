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
