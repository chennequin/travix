Run the application using:
mvn spring-boot:run

There is still some improvements that would need to be done in a real application:
- use the Money pattern
- implements some property-based testing to enforce use cases, particularly edge cases

The data is still hard-coded inside the service layer, which is perfectly acceptable in a TDD approach,
we meet indeed the requirement, but it still needs a proper refactoring to reach production ready code.

I am clearly outside of TDD for this solution, this is a real shame,
I've spent more than two hours now, I am forced to shortcut in order to meet the requirements
with the required deadline.

- Needs to test BigDecimal of money calculation is of exact rounding with two decimal.
- need to test the tax calculation of ToughJet
- need to test the number of adults vs number of passengers in ToughJet api
- need to test date conversions between ToughJet, CrazyAir, BusyFlights beans
- need to test merging of the collections
- need to test the ordering of the final collection
- need to understand/specify/test what's going on exactly with dates in ToughJet responses (no one is provided)

I should also probably take record of every error I get and write a test for it, example:
java.time.DateTimeException: Invalid value for ClockHourOfAmPm (valid values 1 - 12): 21

In further improvements, I would go back to the first beans I've created and write tests for them
(though there's already an implementation for them, I know I've missed this point of TDD).