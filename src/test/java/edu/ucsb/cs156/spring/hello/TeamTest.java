package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class TeamTest {

    @Test
    public void defaultConstructor_initializes_fields() {
        Team team = new Team();
        assertEquals("", team.getName());
        assertTrue(team.getMembers().isEmpty());
    }

    @Test
    public void constructor_sets_name() {
        Team team = new Team("test-team");
        assertEquals("test-team", team.getName());
        assertTrue(team.getMembers().isEmpty());
    }

    @Test
    public void addMember_adds_members() {
        Team team = new Team("test-team");
        team.addMember("Alice");
        team.addMember("Bob");

        assertEquals(Arrays.asList("Alice", "Bob"), team.getMembers());
    }

    @Test
    public void setName_updates_name() {
        Team team = new Team("old");
        team.setName("new");

        assertEquals("new", team.getName());
    }

    @Test
    public void setMembers_updates_members() {
        Team team = new Team("test-team");
        ArrayList<String> members =
            new ArrayList<>(Arrays.asList("Alice", "Bob"));

        team.setMembers(members);

        assertEquals(members, team.getMembers());
    }

    @Test
    public void equals_same_object() {
        Team team = new Team("test-team");
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_identical_teams() {
        Team first = new Team("test-team");
        Team second = new Team("test-team");

        assertTrue(first.equals(second));
    }

    @Test
    public void equals_different_names() {
        Team first = new Team("first");
        Team second = new Team("second");

        assertFalse(first.equals(second));
    }

    @Test
    public void equals_different_members() {
        Team first = new Team("test-team");
        Team second = new Team("test-team");
        second.addMember("Alice");

        assertFalse(first.equals(second));
    }

    @Test
    public void equals_non_team_object() {
        Team team = new Team("test-team");

        assertFalse(team.equals("test-team"));
        assertFalse(team.equals(null));
    }

    @Test
    public void toString_returns_correct_string() {
        Team team = new Team("test-team");
        team.addMember("Alice");

        assertEquals(
            "Team(name=test-team, members=[Alice])",
            team.toString()
        );
    }

    @Test
    public void hashCode_returns_expected_value() {
        Team team = new Team("test-team");
        team.addMember("Alice");

        int expected =
            team.getName().hashCode() |
            team.getMembers().hashCode();

        assertEquals(expected, team.hashCode());
    }
}