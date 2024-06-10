db.createCollection('glasses', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'glasses',
      required: ['brand', 'supplier', 'price', 'client'],
      properties: {
        brand: {
          bsonType: 'object',
          title: 'object',
          properties: {
            Plastic: {
              bsonType: 'string'
            },
            Metallic: {
              bsonType: 'string'
            },
            floating: {
              bsonType: 'string'
            }
          }
        },
        supplier: {
          bsonType: 'object',
          title: 'object',
          required: ['address'],
          properties: {
            name: {
              bsonType: 'string'
            },
            address: {
              bsonType: 'object',
              title: 'object',
              properties: {
                street: {
                  bsonType: 'string'
                },
                number: {
                  bsonType: 'int'
                },
                flat: {
                  bsonType: 'int'
                },
                door: {
                  bsonType: 'int'
                },
                zip_code: {
                  bsonType: 'int'
                },
                city: {
                  bsonType: 'string'
                },
                country: {
                  bsonType: 'string'
                }
              }
            },
            phone: {
              bsonType: 'string'
            },
            fax: {
              bsonType: 'string'
            },
            nif: {
              bsonType: 'string'
            }
          }
        },
        price: {
          bsonType: 'double'
        },
        client: {
          bsonType: 'object',
          title: 'object',
          required: ['address'],
          properties: {
            name: {
              bsonType: 'string'
            },
            address: {
              bsonType: 'object',
              title: 'object',
              properties: {
                street: {
                  bsonType: 'string'
                },
                number: {
                  bsonType: 'int'
                },
                flat: {
                  bsonType: 'int'
                },
                door: {
                  bsonType: 'int'
                },
                zip_code: {
                  bsonType: 'int'
                },
                city: {
                  bsonType: 'string'
                },
                country: {
                  bsonType: 'string'
                }
              }
            },
            phone: {
              bsonType: 'string'
            },
            email: {
              bsonType: 'string'
            },
            date_register: {
              bsonType: 'date'
            }
          }
        }
      }
    }
  },
  autoIndexId: true
});