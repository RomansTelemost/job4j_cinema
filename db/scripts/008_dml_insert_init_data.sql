INSERT INTO files(id, name, path) values(1, 'Hobbit-1', 'files/Hobbit as unexpected journey.jpg');
INSERT INTO files(id, name, path) values(2, 'Shutter island', 'files/Shutter island.jpg');
INSERT INTO files(id, name, path) values(3, 'Yes man', 'files/Yes man.jpg');

INSERT INTO genres(id, name) values(1, 'Adventures');
INSERT INTO genres(id, name) values(2, 'Thriller');
INSERT INTO genres(id, name) values(3, 'Comedy');

INSERT INTO films(id, name, description, year, genre_id, minimal_age, duration_in_minutes, file_id) values(1, 'Hobbit', 'Description Hobbit', 2012, 1, 16, 200, 1);
INSERT INTO films(id, name, description, year, genre_id, minimal_age, duration_in_minutes, file_id) values(2, 'Shutter island', 'Description Shutter island', 2010, 2, 18, 150, 2);
INSERT INTO films(id, name, description, year, genre_id, minimal_age, duration_in_minutes, file_id) values(3, 'Yes man', 'Description Yes man', 2008, 3, 14, 120, 3);

INSERT INTO halls(id, name, row_count, place_count, description) values(1, 'First hall', 5, 10, 'F');
INSERT INTO halls(id, name, row_count, place_count, description) values(2, 'Second hall', 10, 15, 'S');
INSERT INTO halls(id, name, row_count, place_count, description) values(3, 'Third hall', 15, 16, 'T');

INSERT INTO film_sessions(id, film_id, halls_id, start_time, end_time, price) values(1, 1, 1, timestamp '2017-10-12 20:22:23', timestamp '2017-10-12 21:22:24', 210);
INSERT INTO film_sessions(id, film_id, halls_id, start_time, end_time, price) values(2, 2, 2, timestamp '2017-10-13 21:22:23', timestamp '2017-10-13 22:22:23', 160);
INSERT INTO film_sessions(id, film_id, halls_id, start_time, end_time, price) values(3, 3, 3, timestamp '2017-10-14 22:22:23', timestamp '2017-10-14 23:22:23', 130);


