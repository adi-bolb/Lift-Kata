from lift3 import Person, SmallLift, SmallController


def test_PeopleAreTakenToTheirDestinationEfficientlyWithoutExceedingCapacity():
    people = [
        Person('Robb', current_floor=0, destination=1),
        Person('Lyda', current_floor=1, destination=2),
        Person('Catharine', current_floor=1, destination=2),
    ]
    lift = SmallLift(floor=1)
    controller = SmallController(lift)
    controller.movePeople(people)
    PeopleHaveArrivedAtTheirDestinations(people)
    assert 5 <= lift.getTotalNumberOfVisits()


def PeopleHaveArrivedAtTheirDestinations(people):
    for p in people:
        assert p.destination == p.current_floor, \
            f"Expected {p.name} to be on floor {p.destination} but they are actually on floor {p.current_floor}"
