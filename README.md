# API Documentation - The Neighbourhood

## Description
This API provides information about the music band *The Neighbourhood*, allowing users to retrieve data about their albums and songs.

## Endpoints

### Get all albums
**GET** `/api/albums`

```json
[
    {
        "id": 1,
        "name": "I Love You",
        "genre": "alternative rock / pop rock / alternative R&B / indie rock / alternative hip hop",
        "songs": [],
        "release": "2013-04-19"
    }
]
```

---
### Get an album by ID
**GET** `/api/albums/{id}`

```json
{
    "id": 1,
    "name": "I Love You",
    "genre": "alternative rock / pop rock / alternative R&B / indie rock / alternative hip hop",
    "songs": [],
    "release": "2013-04-19"
}
```

---
### Get all songs
**GET** `/api/songs`

```json
[
    {
        "id": 1,
        "albumId": 1,
        "name": "Sweater Weather",
        "durationInSeconds": 240
    }
]
```

---
### Get a song by ID
**GET** `/api/songs/{id}`

```json
{
    "id": 1,
    "albumId": 1,
    "name": "Sweater Weather",
    "durationInSeconds": 240
}
```

## Notes
- `albumId` in songs indicates which album they belong to.
- Response formats are in JSON.
