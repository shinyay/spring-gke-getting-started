# Live Coding Demo for Spring

Overview

## Description

## Demo

### 1. Spring Initilizr to create project template

```
$ curl https://start.spring.io/starter.zip -d type=gradle-project -d dependencies=web,actuator -o spring.zip
```

### 2. Entity
#### 2.1. Data Class
#### 2.2. Enum

### 3. Repository
- Find
- Save
- Update
- Remove

### 4. Controller
- RestController
- RequestMapping
- GetMapping
- PostMapping
- PutMapping
- DeleteMapping

### 5. Actuator
- Actuator Enabled
```
management:
  endpoints:
    web:
      exposure:
        include: '*'
```

- Build Information
```
springBoot {
	buildInfo()
}
```

- Git Information
```
com.gorylenko.gradle-git-properties
```

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
