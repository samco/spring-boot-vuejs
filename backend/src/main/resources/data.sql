INSERT INTO user(id, name, email)
SELECT hibernate_sequence.NEXTVAL, 'Norbert Siegmund', 'norbert@example.com';

INSERT INTO user(id, name, email)
SELECT hibernate_sequence.NEXTVAL, 'Jonas Hecht', 'jonas@example.com';

INSERT INTO book(id, title, author, isbn)
SELECT hibernate_sequence.NEXTVAL, 'To Kill A Mockingbird', 'Harper Lee', '9780446777889';

INSERT INTO loan(id, user_id, book_id)
SELECT hibernate_sequence.NEXTVAL, (SELECT id FROM user WHERE email = 'norbert@example.com'), (SELECT id FROM book WHERE title = 'To Kill A Mockingbird');