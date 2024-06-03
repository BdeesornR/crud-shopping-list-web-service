CREATE SCHEMA IF NOT EXISTS shopping_list;

SET search_path = shopping_list;

CREATE TABLE IF NOT EXISTS shopping_list.sl_user (
    id SERIAL NOT NULL PRIMARY KEY,
    username VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(50),
    salt BYTEA NOT NULL,
    hashed_password BYTEA NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20),
    updated_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS shopping_list.sl_role (
    id SERIAL NOT NULL PRIMARY KEY,
    fk_user_id INTEGER NOT NULL REFERENCES shopping_list.sl_user(id),
    module_code VARCHAR(20) NOT NULL,
    can_view VARCHAR(1) NOT NULL,
    can_create VARCHAR(1) NOT NULL,
    can_update VARCHAR(1) NOT NULL,
    can_delete VARCHAR(1) NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20),
    updated_date TIMESTAMP
);
