create table if not exists ville (id bigint generated by default as identity, code_insee varchar(255), code_postal varchar(255), complement varchar(255), latitude double not null, longitude double not null, nom varchar(255), primary key (id));
create table if not exists client (id bigint generated by default as identity, nom varchar(255), ville_id bigint, primary key (id), foreign key (ville_id) references ville);
create table if not exists colonne (id bigint generated by default as identity, nom varchar(255), primary key (id));
create table if not exists developpeur (id bigint generated by default as identity, date_naissance date, email varchar(255), nom varchar(255), prenom varchar(255), primary key (id));
create table if not exists projet (id bigint generated by default as identity, code varchar(3), date_heure_creation timestamp, date_heure_livraison timestamp, nom varchar(255) not null, client_id bigint, primary key (id), foreign key (client_id) references client);
create table if not exists projet_developpeurs (projets_id bigint not null, developpeurs_id bigint not null, foreign key (developpeurs_id) references developpeur, foreign key (projets_id) references projet);
create table if not exists type_tache (id bigint generated by default as identity, couleur varchar(255), description clob, nom varchar(50), primary key (id));
create table if not exists tache (id bigint generated by default as identity, date_creation timestamp, intitule varchar(255), nb_heures_effectives integer not null, nb_heures_prevues integer not null check (nb_heures_prevues<=144 AND nb_heures_prevues>=1), colonne_actuelle_id bigint, developpeur_id bigint, projet_id bigint, type_tache_id bigint, primary key (id), foreign key (colonne_actuelle_id) references colonne, foreign key (developpeur_id) references developpeur, foreign key (projet_id) references projet, foreign key (type_tache_id) references type_tache);
