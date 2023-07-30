# Dynamic Cascade Dropdown
For `@OneToMany` with `@JoinColumn` , the join column needs to go to the Table referring to `Many` (i.e, State / City ) because this will allow one country to have many states and one state to have many cities.

---

```java
public class Country {
    @Id
    private Integer id;
    private String name;
    @OneToMany
    @JoinColumn(name = "country_id_fk")
    private Set<State> states;
}
```

```java
public class State {

    @Id
    private Integer id;
    private String name;
    @OneToMany
    @JoinColumn(name = "state_id_fk")
    private Set<City> cities;
}
```

```java
public class City {

    @Id
    private Integer id;
    private String name;
}
```
---

### Get all Countries
`Request:`
    ```
    GET   <IP>:<PORT>/api/getCountries
    ```

`Response:` `[[301,"India"],[302,"USA"]]`

---
### Get States by Country ID
`Request:`
    ```
    GET   <IP>:<PORT>/api/getStates?countryId=301
    ```

`Response:` `[[201,"Telangana"],[202,"Karnataka"]]`

---
### Get Cities by State ID
`Request:`
    ```
    GET   <IP>:<PORT>/api/getCities?stateId=201
    ```

`Response:` `[[101,"Hyderabad"],[102,"Warangal"]]`

---

---
## Database 
```http
  Country
```

| id | name     |                
| :-------- | :------- |
| `primary_key` | `string` | 

```http
  State
```
| id | name     | country_id_fk                       |
| :-------- | :------- | :-------------------------------- |
| `primary_key`      | `string` | `foreign key` |


```http
  City
```

| id | name     | state_id_fk                       |
| :-------- | :------- | :-------------------------------- |
| `primary_key`      | `string` | `foreign key` |

---

visit - `/src/main/resources/static/images/`


