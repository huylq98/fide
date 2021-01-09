-- Data for League
insert into league(name, year, location, heldtimes, description)
values ('SwissLeague', 2020, 'Switzerland', 5, '');

-- Data for Player
insert into player(name, dob, nationality, elorating, note)
values ('Henry Nguyen', '1998-04-15', 'Viet Nam', 2600, '');

insert into player(name, dob, nationality, elorating, note)
values ('Thomas Le', '1998-10-02', 'Viet Nam', 2800, '');

insert into player(name, dob, nationality, elorating, note)
values ('Anh Duy', '1998-01-29', 'Viet Nam', 2745, '');

-- Data for Player In League
insert into league_player (league_id, player_id)
values (1, 1);

insert into league_player (league_id, player_id)
values (1, 2);

insert into league_player (league_id, player_id)
values (1, 3);

-- Data for Match
insert into match(firstplayer, secondplayer, round)
values ('1', '2', 'Round 1');