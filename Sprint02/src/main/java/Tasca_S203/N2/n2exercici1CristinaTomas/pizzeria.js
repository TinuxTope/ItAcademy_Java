db.createCollection('shop', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'shop',
      required: ['order', 'employeed', 'adress'],
      properties: {
        name: {
          bsonType: 'string'
        },
        order: {
          bsonType: 'object',
          title: 'object',
          required: ['id_order', 'order', 'product', 'total_price', 'date_order'],
          properties: {
            id_order: {
              bsonType: 'objectId'
            },
            order: {
              bsonType: 'object',
              title: 'object',
              required: ['id', 'client', 'delivery_driver'],
              properties: {
                id: {
                  bsonType: 'objectId'
                },
                client: {
                  bsonType: 'object',
                  title: 'object',
                  required: ['id', 'name', 'lastname', 'phone', 'adress'],
                  properties: {
                    id: {
                      bsonType: 'objectId'
                    },
                    name: {
                      bsonType: 'string'
                    },
                    lastname: {
                      bsonType: 'string'
                    },
                    phone: {
                      bsonType: 'int'
                    },
                    adress: {
                      bsonType: 'object',
                      title: 'object',
                      required: ['street', 'zip_code', 'town', 'city'],
                      properties: {
                        street: {
                          bsonType: 'string'
                        },
                        zip_code: {
                          bsonType: 'int'
                        },
                        town: {
                          bsonType: 'string'
                        },
                        city: {
                          bsonType: 'string'
                        }
                      }
                    }
                  }
                },
                delivery_driver: {
                  bsonType: 'objectId'
                },
                take - awey: {
                  bsonType: 'bool'
                }
              }
            },
            product: {
              bsonType: 'object',
              title: 'object',
              required: ['id', 'type', 'quantity', 'price'],
              properties: {
                id: {
                  bsonType: 'objectId'
                },
                type: {
                  bsonType: 'object',
                  title: 'object',
                  required: ['pizza', 'hamburger', 'drink'],
                  properties: {
                    pizza: {
                      bsonType: 'object',
                      title: 'object',
                      properties: {
                        category: {
                          enum:
                        }
                      }
                    },
                    hamburger: {
                      bsonType: 'object',
                      title: 'object',
                      properties: {
                        category: {
                          bsonType: 'string'
                        }
                      }
                    },
                    drink: {
                      bsonType: 'object',
                      title: 'object',
                      required: ['Type'],
                      properties: {
                        Type: {
                          enum:
                        }
                      }
                    }
                  }
                },
                quantity: {
                  bsonType: 'int'
                },
                price: {
                  bsonType: 'double'
                },
                information: {
                  bsonType: 'object',
                  title: 'object',
                  required: ['description', 'photography'],
                  properties: {
                    description: {
                      bsonType: 'long'
                    },
                    photography: {
                      bsonType: 'symbol'
                    }
                  }
                }
              }
            },
            total_price: {
              bsonType: 'double'
            },
            date_order: {
              bsonType: 'date'
            }
          }
        },
        employeed: {
          bsonType: 'object',
          title: 'object',
          required: ['id_employeed', 'name', 'surname', 'nif', 'phone', 'job'],
          properties: {
            id_employeed: {
              bsonType: 'objectId'
            },
            name: {
              bsonType: 'string'
            },
            surname: {
              bsonType: 'string'
            },
            nif: {
              bsonType: 'int'
            },
            phone: {
              bsonType: 'int'
            },
            job: {
              bsonType: 'object',
              title: 'object',
              required: ['deliber_driver', 'cook'],
              properties: {
                deliber_driver: {
                  bsonType: 'string'
                },
                cook: {
                  bsonType: 'string'
                }
              }
            }
          }
        },
        adress: {
          bsonType: 'object',
          title: 'object',
          required: ['street', 'zip_code', 'town', 'city'],
          properties: {
            street: {
              bsonType: 'string'
            },
            zip_code: {
              bsonType: 'int'
            },
            town: {
              bsonType: 'string'
            },
            city: {
              bsonType: 'string'
            }
          }
        }
      }
    }
  },
  autoIndexId: true
});