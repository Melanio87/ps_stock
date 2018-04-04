select ven_codigo,ven_fecha,ven_hora,ven_codven,acc_nombre,itv_codpro,pro_descri,
itv_canti,itv_precio,ven_total,ven_cliente,case when cli_nombre is null then 'Ocacional' else cli_nombre end ,ven_tipo,ven_obs
from ventas left join clientes cli on cli.cli_codigo = ventas.ven_cliente,item_ventas,productos,acceso
where pro_codigo=itv_codpro and ven_codigo=itv_codven 
and acc_id=ven_codven 