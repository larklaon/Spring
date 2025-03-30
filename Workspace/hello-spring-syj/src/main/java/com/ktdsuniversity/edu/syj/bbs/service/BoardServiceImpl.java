package com.ktdsuniversity.edu.syj.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.syj.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.syj.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.syj.bbs.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public BoardListVO getAllBoard() {

		BoardListVO boardListVO = new BoardListVO();

		boardListVO.setBoardCnt(boardDao.getBoardAllCount());

		boardListVO.setBoardList(boardDao.getAllBoard());
		return boardListVO;
	}
	
	@Override
	public boolean createNewBoard(BoardVO boardVO) {

		int createCount = boardDao.createNewBoard(boardVO);

		return createCount > 0;
	}
	
	@Override
	public BoardVO getOneBoard(int id, boolean isIncrease) {
		if (isIncrease) {

			int updateCount = boardDao.increaseViewCount(id);
			if (updateCount == 0) {

				throw new IllegalArgumentException("잘못된 접근입니다.");
			}
		}

		BoardVO boardVO = boardDao.getOneBoard(id);
		if (boardVO == null) {

			throw new IllegalArgumentException("잘못된 접근입니다.");
		}
		return boardVO;
	}
	
	@Override
	public boolean updateOneBoard(BoardVO boardVO) {

		int updateCount = boardDao.updateOneBoard(boardVO);
		return updateCount > 0;
	}

	@Override
	public boolean deleteOneBoard(int id) {

		int deleteCount = boardDao.deleteOneBoard(id);
		return deleteCount > 0;
	}

}


