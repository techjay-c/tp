package seedu.address.model.treatment;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;

public class Treatment {

    public final TreatmentCost cost;
    public final TreatmentTime time;
    public final TreatmentName name;

    public Treatment(TreatmentName name, TreatmentCost cost, TreatmentTime time) {
        requireAllNonNull(name, cost, time);
        this.cost = cost;
        this.time = time;
        this.name = name;
    }

    public TreatmentCost getCost() {
        return cost;
    }

    public TreatmentTime getTime() {
        return time;
    }

    public TreatmentName getName() {
        return name;
    }

    /**
     * Returns true if both treatments have the same name. This defines a weaker notion of equality
     * between two treatments.
     */
    public boolean isSameTreatment(Treatment otherTreatment) {
        if (otherTreatment == this) {
            return true;
        }

        return otherTreatment != null
            && otherTreatment.getName().equals(getName());
    }

    /**
     * Returns true if both patients have the same identity and data fields. This defines a stronger
     * notion of equality between two patients.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Treatment)) {
            return false;
        }

        Treatment otherTreatment = (Treatment) other;
        return getTime().equals(otherTreatment.getTime())
            && getName().equals(otherTreatment.getName())
            && getCost().equals(otherTreatment.getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCost(), getTime());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("name", getName())
            .add("cost", getCost())
            .add("time", getTime())
            .toString();
    }


}
