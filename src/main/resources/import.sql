USE db;
INSERT INTO provincia (descripcion) VALUES  ('Buenos Aires'),  ('La Pampa');

INSERT INTO departamento (descripcion,provincia_id) VALUES  ('Moron',(SELECT id FROM provincia WHERE descripcion = 'Buenos Aires')),  ('La matanza',(SELECT id FROM provincia WHERE descripcion = 'Buenos Aires')),  ('Capital',(SELECT id FROM provincia WHERE descripcion = 'La Pampa')),  ('Catrilo',(SELECT id FROM provincia WHERE descripcion = 'La Pampa'));

INSERT INTO localidad (descripcion,departamento_id) VALUES  ('Moron',(SELECT id FROM departamento WHERE descripcion = 'Moron')),  ('Haedo',(SELECT id FROM departamento WHERE descripcion = 'Moron')),  ('San Justo',(SELECT id FROM departamento WHERE descripcion = 'La matanza')),  ('Ramos Mejia',(SELECT id FROM departamento WHERE descripcion = 'La matanza')),  ('Santa Rosa',(SELECT id FROM departamento WHERE descripcion = 'Capital')),  ('Anguil',(SELECT id FROM departamento WHERE descripcion = 'Capital')),  ('Catrilo',(SELECT id FROM departamento WHERE descripcion = 'Catrilo')),  ('Relmo',(SELECT id FROM departamento WHERE descripcion = 'Catrilo'));

INSERT INTO mediospago (descripcion,tipo) VALUES ('Efectivo',1),('Tarjeta',2),('Electronico',3)


