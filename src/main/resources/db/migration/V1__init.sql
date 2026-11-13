CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY ,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL CHECK (role IN ('ADMIN','MEMBER'))
);

CREATE TABLE secret(
    id BIGSERIAL PRIMARY KEY,
    owner_id BIGINT NOT NULL,
    label VARCHAR(100) NOT NULL,
    value TEXT NOT NULL,
    CONSTRAINT fk_owner_id FOREIGN KEY (owner_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE access_log(
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    secret_id BIGINT NOT NULL,
    result VARCHAR(20) NOT NULL CHECK (result IN ('SUCCESS', 'FAILURE','DENIED','ERROR')),
    consulted_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT fk_secret_id_log FOREIGN KEY(secret_id) REFERENCES secret(id)
);

CREATE TABLE share(
    id BIGSERIAL PRIMARY KEY,
    secret_id BIGINT NOT NULL,
    shared_user_id BIGINT NOT NULL,
    shared_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_secret_id_share FOREIGN KEY(secret_id) REFERENCES secret(id) ON DELETE CASCADE,
    CONSTRAINT fk_shared_user_id FOREIGN KEY(shared_user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT uq_secret_id_shared_user_id UNIQUE (secret_id,shared_user_id)

);



