-- insert admin
INSERT INTO "user"
    ("name", email, password)
VALUES
    ('admin', 'admin@email.com', '$2a$10$QBuMJLbVmHzgvTwpxDynSetACNdCBjU5zgo.81RWEDzH46aUrgcNK');

-- insert roles
INSERT INTO role
    ("name", initials, description, created_by)
VALUES
    ('ADMINISTRADOR', 'ADM', 'Administrador do sistema', (SELECT id FROM "user" WHERE email = 'admin@email.com')),
    ('CLIENTE', 'CLIENT', 'Cliente da loadora de veiculos', (SELECT id FROM "user" WHERE email = 'admin@email.com')),
    ('FUNCIONARIO', 'EMPLOYEE', 'Funcionario da loadora de veiculos', (SELECT id FROM "user" WHERE email = 'admin@email.com'));

-- put roles into admin
INSERT INTO user_role
    (user_id, role_id)
VALUES
    (
        (SELECT id FROM "user" WHERE email = 'admin@email.com'),
        (SELECT id FROM "role" WHERE initials = 'ADM')
    ),
    (
        (SELECT id FROM "user" WHERE email = 'admin@email.com'),
        (SELECT id FROM "role" WHERE initials = 'CLIENT')
    ),
    (
        (SELECT id FROM "user" WHERE email = 'admin@email.com'),
        (SELECT id FROM "role" WHERE initials = 'EMPLOYEE')
    );