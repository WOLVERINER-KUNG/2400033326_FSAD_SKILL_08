# Skill 8 – Spring Boot JPQL & Query Methods

## Run the project

```
mvn spring-boot:run
```

App starts on **http://localhost:8080**  
H2 Console: **http://localhost:8080/h2-console**  
(JDBC URL: `jdbc:h2:mem:productdb`, user: `sa`, password: *(blank)*)

---

## API Endpoints

### CRUD
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/products` | List all products |
| GET | `/products/{id}` | Get product by ID |
| POST | `/products` | Create a product |
| PUT | `/products/{id}` | Update a product |
| DELETE | `/products/{id}` | Delete a product |

### Derived Query Methods
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/products/category/{category}` | By category |
| GET | `/products/filter?min=100&max=500` | Price range filter |
| GET | `/products/search?keyword=phone` | Search by name (contains) |
| GET | `/products/category/{category}/under?maxPrice=200` | Category + max price |

### JPQL Queries
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/products/sorted` | All products sorted by price ASC |
| GET | `/products/expensive/{price}` | Products above given price |
| GET | `/products/most-expensive` | Highest priced product |

### Modifying JPQL
| Method | URL | Body | Description |
|--------|-----|------|-------------|
| PATCH | `/products/category/{category}/apply-discount` | `{"factor":0.9}` | Multiply prices by factor |
| DELETE | `/products/category/{category}/all` | – | Delete all in category |

---

## Sample POST body

```json
{
  "name": "Google Pixel 8",
  "category": "Electronics",
  "price": 699.99
}
```
