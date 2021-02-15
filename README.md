# API-postalCode
es una api para consultar codigos postal con conexión a una base de datos 
API hecha con el framework de Spring mvc, con una conexion a base de datos MariaDB mediante el conector JDBCTemplate

Ruta para la consulta es mediante:
GET /zip-codes/{codigoPostal}

ejemplo

/zip-codes/06140

Regresa un JSON con la información solicitada

{
  "zip_code": "06140",
  "locality": "CIUDAD DE MEXICO",
  "federal_entity": "CIUDAD DE MEXICO",
  "settlements": [
    {
      "name": "CONDESA",
      "zone_type": "Urbano",
      "settlement_type": "Colonia"
    }
  ],
  "municipality": "CUAUHTEMOC"
}

