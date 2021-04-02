---
title: PMD Release Notes
permalink: pmd_release_notes.html
keywords: changelog, release notes
---

## {{ site.pmd.date }} - {{ site.pmd.version }}

The PMD team is pleased to announce PMD {{ site.pmd.version }}.

This is a {{ site.pmd.release_type }} release.

{% tocmaker is_release_notes_processor %}

### New and noteworthy

#### PLSQL parsing exclusions

The PMD PLSQL parser might not parse every valid PL/SQL code without problems.
In order to still use PMD on such files, you can now mark certain lines for exclusion from
the parser. More information can be found in the [language specific documentation for PLSQL](pmd_languages_plsql.html).

### Fixed Issues

*   apex-design
    *   [#3142](https://github.com/pmd/pmd/issues/3142): \[apex] ExcessiveClassLength multiple warning on the same class
*   java
    *   [#3117](https://github.com/pmd/pmd/issues/3117): \[java] Infinite loop when parsing invalid code nested in lambdas
    *   [#3145](https://github.com/pmd/pmd/issues/3145): \[java] Parse exception when using "record" as variable name
*   java-bestpractices
    *   [#3118](https://github.com/pmd/pmd/issues/3118): \[java] UnusedPrivateMethod false positive when passing in lombok.val as argument
    *   [#3144](https://github.com/pmd/pmd/issues/3144): \[java] GuardLogStatement can have more detailed example
    *   [#3155](https://github.com/pmd/pmd/pull/3155): \[java] GuardLogStatement: False negative with unguarded method call
    *   [#3160](https://github.com/pmd/pmd/issues/3160): \[java] MethodReturnsInternalArray does not consider static final fields and fields initialized with empty array
*   java-errorprone
    *   [#2977](https://github.com/pmd/pmd/issues/2977): \[java] CloseResource: false positive with reassignment detection
    *   [#3146](https://github.com/pmd/pmd/issues/3146): \[java] InvalidLogMessageFormat detection failing when String.format used
    *   [#3148](https://github.com/pmd/pmd/issues/3148): \[java] CloseResource false positive with Objects.nonNull
    *   [#3165](https://github.com/pmd/pmd/issues/3165): \[java] InvalidLogMessageFormat detection failing when String.format used in a variable
*   java-performance
    *   [#2427](https://github.com/pmd/pmd/issues/2427): \[java] ConsecutiveLiteralAppend false-positive with builder inside lambda
    *   [#3152](https://github.com/pmd/pmd/issues/3152): \[java] ConsecutiveLiteralAppends and InsufficientStringBufferDeclaration: FP with switch expressions
*   plsql
    *   [#195](https://github.com/pmd/pmd/issues/195): \[plsql] Ampersand '&' causes PMD processing error in sql file - Lexical error in file

### External Contributions

*   [#3161](https://github.com/pmd/pmd/pull/3161): \[plsql] Add support for lexical parameters in SQL*Plus scripts, allow excluding lines which the parser does not understand - [Henning von Bargen](https://github.com/hvbtup)
*   [#3167](https://github.com/pmd/pmd/pull/3167): \[java] Minor typo in quickstart ruleset - [Austin Tice](https://github.com/AustinTice)

### Stats
* 49 commits
* 27 closed tickets & PRs
* Days since last release: 28

{% endtocmaker %}

