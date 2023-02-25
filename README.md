# D2HD

## Brief

The illustration is shown as a graph. Consignee receives a visualization of 
his/her preceding 4 orders. Each order is illustrated as a waypoint.
```
*   *   🏠
 \ / \ / 
  *   *
```

Every order completed is marked with an 'x'.
```
x   x   🏠
 \ / \ / 
  x   *
```

Consignee's web application will not display the visualization if the 
current delivery is not within their preceding 4 orders:
```
x   *   *   🏠
 \ / \ / \ /     INVALID. Consignee's app will NOT display this visualization.
  *   *   *
```

Instead, the consignee's web application will simply display:
```

  Your order is out for delivery.

```

## Frontend
React.

## Backend
Spring Boot.

[//]: # (The api is categorized into two services, namely)

## Database
Postgres.