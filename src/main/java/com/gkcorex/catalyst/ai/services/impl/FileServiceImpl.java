package com.gkcorex.catalyst.ai.services.impl;

import com.gkcorex.catalyst.ai.dtos.project.FileContentResponse;
import com.gkcorex.catalyst.ai.dtos.project.FileNode;
import com.gkcorex.catalyst.ai.services.FileService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
  @Override
  public List<FileNode> getFileTree(Long userId, Long projectId) {
    return List.of();
  }

  @Override
  public FileContentResponse getFileContent(Long userId, Long projectId, String path) {
    return null;
  }
}
