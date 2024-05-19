package com.space.satellites.repositories;

import com.space.satellites.models.Launcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LauncherRepository extends JpaRepository<Launcher, String> {

    @Query(value = "SELECT id FROM launcher", nativeQuery = true)
    List<String> findAllIds();
}
