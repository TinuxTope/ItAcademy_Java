db.createCollection('clientes', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'clientes',
      properties: {
        name: {
          bsonType: 'string'
        },
        data: {
          bsonType: 'object',
          title: 'object',
          required: ['address', 'phone', 'email'],
          properties: {
            address: {
              bsonType: 'string'
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
        },
        last_shopping: {
          bsonType: 'object',
          title: 'object',
          required: ['brand'],
          properties: {
            brand: {
              bsonType: 'object',
              title: 'object',
              required: ['lenses_graduation', 'frame_Type', 'frame_color', 'price'],
              properties: {
                lenses_graduation: {
                  bsonType: 'object',
                  title: 'object',
                  properties: {
                    left: {
                      bsonType: 'double'
                    },
                    right: {
                      bsonType: 'double'
                    }
                  }
                },
                frame_Type: {
                  bsonType: 'object',
                  title: 'object',
                  properties: {
                    metalic: {
                      bsonType: 'string'
                    },
                    paste: {
                      bsonType: 'string'
                    },
                    floating: {
                      bsonType: 'string'
                    }
                  }
                },
                frame_color: {
                  bsonType: 'object',
                  title: 'object',
                  properties: {
                    left: {
                      bsonType: 'string'
                    },
                    right: {
                      bsonType: 'string'
                    }
                  }
                },
                price: {
                  bsonType: 'decimal'
                }
              }
            }
          }
        }
      }
    }
  },
  autoIndexId: true
});