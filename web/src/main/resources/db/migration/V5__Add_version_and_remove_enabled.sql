ALTER TABLE users ADD COLUMN version BIGINT DEFAULT 0;

ALTER TABLE users DROP COLUMN enabled;