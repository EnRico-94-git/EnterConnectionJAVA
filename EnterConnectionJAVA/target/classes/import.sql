-- Parceiros --
insert into parceiro (idParceiro, nmParceiro, areaAtuando, avaliacaoDesemp, tpParceria) 
values (1, 'Parceiro A', 'Tecnologia', 'Excelente', 'Plataforma');
insert into parceiro (idParceiro, nmParceiro, areaAtuando, avaliacaoDesemp, tpParceria) 
values (2, 'Parceiro B', 'Consultoria', 'Bom', 'Consultoria');
insert into parceiro (idParceiro, nmParceiro, areaAtuando, avaliacaoDesemp, tpParceria) 
values (3, 'Parceiro C', 'Educação', 'Satisfatório', 'Educação');

-- Empresa --
insert into empresa (idEmpresa, nmEmpresa, segmento, avaliacao, parceiros) 
values (1, 'Empresa A', 'Tecnologia', 'Excelente', 'Parceiro A');
insert into empresa (idEmpresa, nmEmpresa, segmento, avaliacao, parceiros) 
values (2, 'Empresa B', 'Consultoria', 'Bom', 'Parceiro B');
insert into empresa (idEmpresa, nmEmpresa, segmento, avaliacao, parceiros) 
values (3, 'Empresa C', 'Educação', 'Satisfatório', 'Parceiro C');

-- Clientess --
insert into cliente (idCliente, nmCliente, email, telefone, endereco) 
values (1, 'Cliente A', 'clienteA@example.com', '123456789', 'Rua A, 123');
insert into cliente (idCliente, nmCliente, email, telefone, endereco) 
values (2, 'Cliente B', 'clienteB@example.com', '987654321', 'Rua B, 456');
insert into cliente (idCliente, nmCliente, email, telefone, endereco) 
values (3, 'Cliente C', 'clienteC@example.com', '456789123', 'Rua C, 789');