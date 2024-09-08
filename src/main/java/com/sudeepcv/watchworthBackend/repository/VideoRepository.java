package com.sudeepcv.watchworthBackend.repository;

import com.sudeepcv.watchworthBackend.modal.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}