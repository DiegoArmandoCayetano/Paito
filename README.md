
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
