# Transaction

분류: 과제
작성일: 2023년 6월 5일
피드백: No

---

## Transaction

<aside>
<img src="https://www.notion.so/icons/package_gray.svg" alt="https://www.notion.so/icons/package_gray.svg" width="40px" /> **Transaction?**

데이터베이스의 상태를 변화시키기 해서 수행하는 작업의 단위.

데이터 베이스는 SQL 한 문장이 아니라 많은 명령문들을 사람이 정하는 기준에 따라 정한다.

ex) 게시판에서 사용자가 올리기 버튼을 누르면 **Insert**문으로 사용자가 입력한 게시글의 데이터를 옮기고, 그 후에 게시판을 구성할 데이터들을 다시 **Select**해서 최신 정보로 유지한다. **여기서 작업의 단위는 insert + select 둘 다 합친 것이다.** 

이러한 작업의 단위를 하나의 **트랜잭션**이라 한다.

- 데이터베이스의 상태를 변환시키는 건 뭘까?
    
    SQL(SELECT,INSERT,DELETE,UPDATE)을 이용해 데이터베이스를 접근 하는 것
    
</aside>

<aside>
<img src="https://www.notion.so/icons/package_gray.svg" alt="https://www.notion.so/icons/package_gray.svg" width="40px" /> **Transaction’s characteristic**

**- 원자성 (Atomicity)**
**트랜잭션이 데이터베이스에 모두 반영되던가, 아니면 전혀 반영이 되지 않아야 한다는 것**

**- 일관성 (Consistency)
트랜잭션의 작업 처리 결과가 항상 일관성이 있어야 한다는 것**
트랜잭션이 진행되는 동안 데이터베이스가 변경되더라도 처음에 트랜잭션을 진행하기 위해 참조한 데이터베이스로 진행되어야함

**- 독립성 (Isolation)
둘 이상의 트랜잭션이 동시에 실행되고 있을 경우 어떤 트랜잭션도 다른 트랜잭션의 연산에 끼어들 수 없다는 것**

**- 지속성 (Durability)
트랜잭션이 성공적으로 완료되었을 경우, 결과는 영구적으로 반영되어야 한다는 것**

</aside>

<aside>
<img src="https://www.notion.so/icons/delivery-truck_gray.svg" alt="https://www.notion.so/icons/delivery-truck_gray.svg" width="40px" /> **Commit & Rollback

- Commit
하나의 트랜잭션이 성공적으로 끝났으며, 데이터베이스가 일관성 있는 상태에 있다는 것을 알려주기 위해 사용하는 연산**
커밋을 사용하면 수행했던 트랜잭션이 로그에 저장된다.

**- Rollback**
하나의 트랜잭션 처리가 비정상적으로 종료되어 트랜잭션의 원자성이 깨져**, 트랜잭션을 처음부터 다시 시작하거나 트랜잭션의 부분적으로만 연산된 결과를 다시 취소시키는 연산**

</aside>