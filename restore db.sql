
TRUNCATE anuvent,categoria,clientes,contacto,deucli,employee,empresa,
entidad,imgpro,item_ventas,mesa,moneda,numfac,productos,
productos_old,proveedor,sector,users,ventas RESTART IDENTITY;

VACUUM FULL anuvent;
VACUUM FULL categoria;
VACUUM FULL clientes;
VACUUM FULL contacto;
VACUUM FULL deucli;
VACUUM FULL employee;
VACUUM FULL empresa;
VACUUM FULL entidad;
VACUUM FULL imgpro;
VACUUM FULL item_ventas;
VACUUM FULL mesa;
VACUUM FULL moneda;
VACUUM FULL numfac;
VACUUM FULL productos;
VACUUM FULL productos_old;
VACUUM FULL proveedor;
VACUUM FULL sector;
VACUUM FULL users;
VACUUM FULL ventas;