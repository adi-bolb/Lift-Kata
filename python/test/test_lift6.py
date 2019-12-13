
from hamcrest import assert_that, equal_to

from lift6 import Direction, floor, Elevator


def test_elevator_will_move_up_and_down_then_standby_until_next_move_down_and_up():
        # Given
        elevator = Elevator(floor(0))

        # When
        elevator.floorCall(floor(56), Direction.DOWN)
        elevator.run()
        elevator.innerElevatorRequest(floor(0))
        isStandby1 = elevator.isStandingBy()
        standbyFloor1 = elevator.currentFloor()
        elevator.floorCall(floor(-5), Direction.UP)
        elevator.run()
        elevator.innerElevatorRequest(floor(26))
        elevator.run()
        isStandby2 = elevator.isStandingBy()
        standbyFloor2 = elevator.currentFloor()

        # Then
        assert_that(isStandby1, equal_to(False))
        assert_that(standbyFloor1, equal_to(floor(56)))
        assert_that(isStandby2, equal_to(True))
        assert_that(standbyFloor2, equal_to(floor(26)))
